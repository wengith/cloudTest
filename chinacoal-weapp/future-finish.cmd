@REM 使用如下命令完成新特性开发，（需要首先commit 到git，本操作将自动push到git服务器上并完成和develop分支的合并及feature分支的删除）
mvn gitflow:feature-finish -DargLine=-Dmaven.test.skip=true