# Git简明使用 

## 日常操作
### 常见命令
```
#从远程库clone
git clone http://git.jsptz.com/jsptz/framework-poc.git
git config --global push.default simple
#创建版本库 
git init
//把文件修改添加到暂存区
git add README.MD
#把暂存区的所有内容提交到当前分支
git commit -m "Add Something" 
#查看当前仓库状态(查看哪些文件变了)
git status
#比较差异(查看变了什么) 
git diff
git diff HEAD -- readme.txt
git diff HEAD^ -- readme.txt
git diff HEAD~2 -- readme.txt
git diff 48dfcb8 -- readme.txt
#查看日志
git log
git log --pretty=oneline
#回退,在Git中，用HEAD表示当前版本，也就是最新的提交1094adb...，上一个版本就是HEAD^，上上一个版本就是HEAD^^，当然往上100个版本写100个^比较容易数不过来，所以写成HEAD~100
#回退到上一个版本
git reset --hard HEAD^
#回退到指定commit id,1094a 为之前的commit id（无需写完整，前几位能区分即可） 
git reset --hard 48dfcb8 
#查看每一次命令和其commit id
git reflog

#命令git checkout -- readme.txt意思就是，把readme.txt文件在工作区的修改全部撤销，这里有两种情况：
#一种是readme.txt自修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；
#一种是readme.txt已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。
#总之，就是让这个文件回到最近一次git commit或git add时的状态。
#git checkout其实是用版本库里的版本替换工作区的版本，无论工作区是修改还是删除，都可以“一键还原”。
git checkout -- readme.txt

#暂存区的修改撤销掉 
git reset HEAD readme.txt

#从版本库中删除该文件
git rm test.txt
#提交
git commit -m "remove test.txt" 

#关联远程库 
git remote add origin git@server-name:path/repo-name.git

#推送到远程服务器 
git push
#第1次加上-u参数进行关联
git push -u origin master
git push origin master
 
#从远程服务器拉
git pull
```

### 分支管理


```
#查看分支：
git branch
#创建分支
git branch <name>
#切换分支
git checkout <name>
#创建+切换分支
git checkout -b <name>
#合并某分支到当前分支
git merge <name>
#删除分支
git branch -d <name>
#查看远程分支
git branch -r

#使用下面两条命令来删除远程分支 
git branch -r -d origin/branch-name  
git push origin :branch-name
#查看分支合并情况 
git log --graph --pretty=oneline --abbrev-commit
```

### 更新fork开发分支

```
git clone http://git.jsptz.com/zhouxianli/framework-poc.git
cd arch6

git fetch 

#首先保证本地仓库的upstream是源项目的URL，若没有则添加
git remote add upstream http://git.jsptz.com/jsptz/framework-poc.git 

#利用fetch和merge合并upstream的develop分支
git fetch upstream
git merge upstream/develop

#此时本地的develop分支就更新至upstream的develop版本。然后利用push将本地分支覆盖到git远程分支上：
git push origin develop:develop
```


## 冲突解决

```
当Git无法自动合并分支时，就必须首先解决冲突。解决冲突后，再提交，合并完成。
解决冲突就是把Git合并失败的文件手动编辑为我们希望的内容，再提交。
```
### 分支策略

在实际开发中，我们应该按照几个基本原则进行分支管理：
首先，master分支应该是非常稳定的，也就是仅用来发布新版本，平时不能在上面干活；
那在哪干活呢？干活都在dev分支上，也就是说，dev分支是不稳定的，到某个时候，比如1.0版本发布时，再把dev分支合并到master上，在master分支发布1.0版本；
你和你的小伙伴们每个人都在dev分支上干活，每个人都有自己的分支，时不时地往dev分支上合并就可以了。


###### Bug分支

```
当前正在dev上进行的工作还没有提交，先存储起来
git stash
git checkout master
git checkout -b issue-101
修复完成后
git add readme.txt
git commit -m "fix bug 101"
切换到master分支，并完成合并，最后删除issue-101分支
git checkout master
git merge --no-ff -m "merged bug fix 101" issue-101
接着回到dev分支干活
git checkout dev
git stash list
有两种方法：
一：用git stash apply恢复，但是恢复后，stash内容并不删除，你需要用git stash drop来删除；
二：用git stash pop，恢复的同时把stash内容也删了：
git stash pop
git stash apply stash@{0}
```

###### Feature分支

```
每添加一个新功能，最好新建一个feature分支，在上面开发，完成后，合并，最后，删除该feature分支。
git checkout -b feature-vulcan
git add vulcan.py
git commit -m "add feature vulcan"
准备合并
git checkout dev
高能预警，此时删除，必须强制删除（丢弃一个没有被合并过的分支）。
git branch -D feature-vulcan
```

## 多人协作


当你从远程仓库克隆时，实际上Git自动把本地的master分支和远程的master分支对应起来了，并且，远程仓库的默认名称是origin。
查看远程库的信息
git remote
git remote -v
推送分支
git push origin master
如果要推送其他分支，比如dev，就改成：
git push origin dev

并不是一定要把本地分支往远程推送，那么，哪些分支需要推送，哪些不需要呢？
master分支是主分支，因此要时刻与远程同步；
dev分支是开发分支，团队所有成员都需要在上面工作，所以也需要与远程同步；
bug分支只用于在本地修复bug，就没必要推到远程了，除非老板要看看你每周到底修复了几个bug；
feature分支是否推到远程，取决于你是否和你的小伙伴合作在上面开发。
```
查看远程库信息，使用git remote -v；
本地新建的分支如果不推送到远程，对其他人就是不可见的；
从本地推送分支，使用git push origin branch-name，如果推送失败，先用git pull抓取远程的新提交；
在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；
建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；
从远程抓取分支，使用git pull，如果有冲突，要先处理冲突 
```

### 多人协作的工作模式：
```
- 首先，可以试图用git push origin <branch-name>推送自己的修改；
- 如果推送失败，则因为远程分支比你的本地更新，需要先用git pull试图合并；
- 如果合并有冲突，则解决冲突，并在本地提交；
- 没有冲突或者解决掉冲突后，再用git push origin <branch-name>推送就能成功！
- 如果git pull提示no tracking information，则说明本地分支和远程分支的链接关系没有创建，用命令git branch --set-upstream-to <branch-name> origin/<branch-name>。
```

###### 变基
rebase操作可以把本地未push的分叉提交历史整理成直线；
rebase的目的是使得我们在查看历史提交的变化时更容易，因为分叉的提交需要三方对比。

###### 标签管理
```
#切换到需要打标签的分支上
git checkout master
git tag v1.0
#查看所有标签（标签不是按时间顺序列出，而是按字母排序的）
git tag
#默认标签是打在最新提交的commit上的。也可以找到历史提交的commit id，然后打上
git log --pretty=oneline --abbrev-commit
git tag v0.9 f52c633
#查看标签信息
git show v0.9
#可以创建带有说明的标签
git tag -a v0.1 -m "version 0.1 released" 1094adb
#删除标签（创建的标签都只存储在本地，不会自动推送到远程）
git tag -d v0.1
#推送标签到远程
git push origin v1.0
git push origin --tags
#删除已经推送到远程的标签
git tag -d v0.9
git push origin :refs/tags/v0.9
```



##  常见问题
### 混乱了怎么办 
```
场景1：当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时，用命令git checkout -- file。

场景2：当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，第一步用命令git reset HEAD <file>，就回到了场景1，第二步按场景1操作。

场景3：已经提交了不合适的修改到版本库时，想要撤销本次提交，参考版本回退一节，不过前提是没有推送到远程库。
```

### 自定义Git

```
让Git显示颜色，会让命令输出看起来更醒目
git config --global color.ui true
设置用户名、邮件
git config --global user.name "Your Name"
git config --global user.email "email@example.com"
```

###### 忽略特殊文件


```
GitHub已经为我们准备了各种配置文件，只需要组合一下就可以使用了。所有配置文件可以直接在线浏览：https://github.com/github/gitignore

忽略文件的原则是：

忽略操作系统自动生成的文件，比如缩略图等；
忽略编译生成的中间文件、可执行文件等，也就是如果一个文件是通过另一个文件自动生成的，那自动生成的文件就没必要放进版本库，比如Java编译产生的.class文件；
忽略你自己的带有敏感信息的配置文件，比如存放口令的配置文件。


把.gitignore也提交到Git，就完成了

###### 强制提交
git add -f App.class
git check-ignore命令检查规则
```

###### 配置别名

```
git config --global alias.st status
```
则 git st == git status
每个仓库的Git配置文件都放在.git/config文件中

### 使用GitHub

```
在GitHub上，可以任意Fork开源仓库；
自己拥有Fork后的仓库的读写权限；
可以推送pull request给官方仓库来贡献代码。
```
### 使用码云

```
码云的免费版本也提供私有库功能，只是有5人的成员上限。
```

### 多个远程库

```
git给远程库起的默认名称是origin，如果有多个远程库，我们需要用不同的名称来标识不同的远程库。
git remote rm origin

git remote add github git@github.com:michaelliao/learngit.git
git remote add gitee git@gitee.com:liaoxuefeng/learngit.git

如果要推送到GitHub，使用命令：

git push github master
如果要推送到码云，使用命令：

git push gitee master
``` 
