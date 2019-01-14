var gulp = require('gulp');
var plugins = require('gulp-load-plugins');         //插件管理器
var debug = require('gulp-debug');                  //控制台打印信息
var changed = require('gulp-changed');              //只编译改动过的文件
var babel = require('gulp-babel');                  //ES6转为ES5
var connect = require('gulp-connect');              //调试服务器
var proxy = require('http-proxy-middleware');       //请求代理转发
var replace = require("gulp-replace");              //文件内容替换
var uglify = require('gulp-uglify');                //用于压缩js
var minifycss = require('gulp-minify-css');         //用于压缩css
//项目目录配置
var sourcePath = 'app';
var targetDevPath = 'target/dev'
var targetDistPath = 'target/dist';

//==========================================开发任务配置=============================================//

gulp.task('watch', function () {
    gulp.watch(sourcePath + '/*.html', ['dev_html_index', 'dev_version']);
    gulp.watch(sourcePath + '/page/**/*.html', ['dev_html', 'dev_version']);
    gulp.watch(sourcePath + '/page/**/*.js', ['dev_js', 'dev_version']);
    gulp.watch(sourcePath + '/css/**/*.css', ['dev_css', 'dev_version']);
});

gulp.task('dev_version', function () {
    return gulp.src(targetDevPath + '/page/version.js')
        .pipe(replace(/var version = "(.*?)"/, function (match, s1) {
            let ver_new = 'var version = "' + ++s1 + '"';
            console.log(match + "\t->\t" + ver_new);
            return ver_new;
        }))
        .pipe(debug({title: 'dev_version:'}))
        .pipe(gulp.dest(targetDevPath + '/page'));
});

gulp.task('dev_html_index', function () {
    return gulp.src(sourcePath + '/*.html')
        .pipe(changed(targetDevPath + '/'))
        .pipe(debug({title: 'dev_html_index:'}))
        .pipe(gulp.dest(targetDevPath + '/'));
});

gulp.task('dev_html', function () {
    return gulp.src(sourcePath + '/page/**/*.html')
        .pipe(changed(targetDevPath + '/page'))
        .pipe(debug({title: 'dev_html:'}))
        .pipe(gulp.dest(targetDevPath + '/page'));
});

gulp.task('dev_js', function () {
    return gulp.src(sourcePath + '/page/**/*.js')
        .pipe(changed(targetDevPath + '/page'))
        .pipe(babel({
            presets: ['es2015'],
            plugins: ["transform-object-assign", "transform-object-rest-spread"]
        }))
        .pipe(replace(/use strict/g, ""))
        .pipe(debug({title: 'dev_js:'}))
        .pipe(gulp.dest(targetDevPath + '/page'));
});

gulp.task('dev_css', function () {
    return gulp.src(sourcePath + '/css/**/*.css')
        .pipe(changed(targetDevPath + '/css'))
        .pipe(debug({title: 'dev_css:'}))
        .pipe(gulp.dest(targetDevPath + '/css'));
});

gulp.task('dev_img', function () {
    return gulp.src(sourcePath + '/img/**/*')
        .pipe(changed(targetDevPath + '/img'))
        .pipe(debug({title: 'dev_img:'}))
        .pipe(gulp.dest(targetDevPath + '/img'));
});

gulp.task('dev_plugin', function () {
    return gulp.src(sourcePath + '/plugin/**/*')
        .pipe(changed(targetDevPath + '/plugin'))
        .pipe(debug({title: 'dev_plugin:'}))
        .pipe(gulp.dest(targetDevPath + '/plugin'));
});

gulp.task('clean', function (cb) {
    var del = require('del');
    del(['target'], cb)
});


//开启测试服务器，并对相应路径做代理转发
gulp.task('dev_webserver', function () {
    connect.server({
        root: targetDevPath,
        host: '0.0.0.0',
        port: 8822,
        livereload: false,
        middleware: function (connect, opt) {
            return [
                proxy('/api/gateway/jwt/oauth', {
                    pathRewrite: {'/api/gateway/jwt/oauth': '/jwt/oauth'},
                    target: 'http://10.10.4.66:18011',
                    changeOrigin: true
                }),
                proxy('/api/**', {
                    target: 'http://10.10.4.66:17051',
                    changeOrigin: true
                })
            ];
        }
    });
});

//默认开发任务，启动带调试信息的系统
gulp.task('default', ['dev_webserver', 'dev_html_index', 'dev_html', 'dev_js', 'dev_css', 'dev_img', 'dev_plugin', 'watch']);

//==========================================测试任务配置=============================================//

gulp.task('dist_js', function () {
    return gulp.src([sourcePath + '/page/**/*.js'])
        .pipe(babel({
            presets: ['es2015'],
            plugins: ["transform-object-assign", "transform-object-rest-spread"]
        }))
        .pipe(removeUseStrict())
        .pipe(uglify())
        .pipe(gulp.dest(targetDistPath + '/page'));
});
gulp.task('dist_css', function () {
    return gulp.src(sourcePath + '/css/**/*') //压缩的文件
        .pipe(minifycss()) //执行压缩
        .pipe(gulp.dest(targetDistPath + '/css')); //输出文件夹
});

gulp.task('dist_plugin', function () {
    return gulp.src([sourcePath + '/plugin/**/*'])
        .pipe(gulp.dest(targetDistPath + '/plugin'));
});

gulp.task('dist_img', function () {
    return gulp.src([sourcePath + '/img/**/*'])
        .pipe(gulp.dest(targetDistPath + '/img'));
});

gulp.task('dist_html', function () {
    return gulp.src([sourcePath + '/page/**/*.html'])
        .pipe(gulp.dest(targetDistPath + '/page'));
});

gulp.task('dist_html_index', function () {
    return gulp.src([sourcePath + '/*.html'])
        .pipe(gulp.dest(targetDistPath + '/'));
});

//测试任务，启动不带调试信息的系统
gulp.task('test', ['dist_img', 'dist_plugin', 'dist_css', 'dist_js', 'dist_html', 'dist_html_index', 'dist_webserver']);

//==========================================发布任务配置=============================================//

//发布任务，清空，然后打包不带调试信息的系统
gulp.task('dist', ['clean', 'dist_plugin', 'dist_img', 'dist_css', 'dist_js', 'dist_html', 'dist_html_index']);
