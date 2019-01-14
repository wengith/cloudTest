define(['jquery','widget/http','widget/dialog','widget/ajax_form', 'service/util_service', 'route_config','bootbox','fileinput','bootstrapui','fileinput-zh'],
 function($,http,dialog,ajax_form,util_service, route_config,bootbox,fileinput,bootstrapui,fileinput_zh)  {
    var page = {
        /**
         * 模块参数
         */
        params: {
              /**
             * 模块参数
             */
            deferred: null,
            $fm: null
        },
        /**
         * 模块入口
         */
        initPage:function() {
            this.params.deferred = $.Deferred();
            //获取页面传输参数
            var stateParams = route_config.getStateParams();

            //初始化并绑定
            this.render(null);
            this.params.$fm = $('#form');
            this.bindEvent();
        },
        /**
         * 事件绑定
         */
        bindEvent:function() {
            $("#uploadlink").on('click',$.proxy(this.stratup,this));
            $("#btn-submit").on('click',$.proxy(this.uploadFile,this));
            $("#btn-close").on('click',$.proxy(this.closeModal,this));
            $("#download").on('click',$.proxy(this.downloadFile,this));
        }, stratup:function(event){
            //打开上传文件的模态框 
            $("#myModal").modal("show"); 
             $("#file").fileinput({
                language: 'zh', //设置语言
                uploadAsync: true,
                /*uploadUrl: $("#file").val(), */
                /*uploadUrl: "",*///上传的地址
                allowedFileExtensions: ["xlsx","xls"],//接收的文件后缀
                showUpload: false, //是否显示上传按钮
                showPreview :true, //是否显示预览
                showCaption: false,//是否显示标题
                showRemove:true,
                browseClass: "btn btn-primary", //按钮样式     
                maxFileCount: 1, //表示允许同时上传的最大文件个数
                enctype: 'multipart/form-data',
                validateInitialCount:true,
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"
            }).on("fileuploaded", function (event, data, previewId, index) {
                var data = data.response.lstOrderImport;
                if (data == undefined) {
                    toastr.error('文件格式类型不正确');
                    return;
                }
            }); 
        },uploadFile:function(event){
             var data = this.params.$fm.serialize();
             http.submit({
                apiName:'excelUpload',
                type: 'POST',
                contentType:'multipart/form-data',
                $form:this.params.$fm,
                success:function(result) {
                  $("#myModal").modal("hide");
                  bootbox.alert("上传成功");
                 }
             });
            //上传属性配置结束   
        }, closeModal:function(event){
            $("#myModal").modal("hide");     
        }, downloadFile:function(event){
            var url = "/api/misc/excel/test/download";
            var fileName = "test.xlsx";
            var form = $("<form></form>").attr("action", url).attr("method", "post");
            form.append($("<input></input>").attr("type", "hidden").attr("name", "fileName").attr("value", fileName));
            form.appendTo('body').submit().remove();

           /*   dialog.page({
                title: '文件下载',
                loadUrl: '/excel/test/download'
            });*/
         /*   window.location.href = '/api/misc/excel/test/download';*/
          /*   let exporturl = route_config.api_service.get(this.options.view.excelDownload);
             window.open(exporturl);*/
         /*  http.get({
                apiName: 'excelDownload',
                type: 'POST',
                setTimeout(3000),
                async:true,
                cache:false,
                success(data) {
                  bootbox.alert("下载成功");
                }
           })*/
        },
        /**
        * 模板渲染
        */
        render:function(data){
            var myTemplate = $.templates("#showExcelmpl");
            myTemplate.link("#excel-impl",{});
            this.params.deferred.resolve('ok');
        }
    };
    return {
        initPage: $.proxy(page.initPage, page)
    };
});