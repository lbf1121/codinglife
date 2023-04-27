## 使用idea做web项目开发图片上传，上传后图片地址无法访问问题
### 前台将上传的图片提交到后台保存时，通过getServletContext().getRealPath("/upload")方法获取的是*/out/artifacts/项目名/upload的地址，并非我想要的"项目/WebRoot/upload"地址，不知为何图片上传到out/*/的目录后在也没的<img src="/upload/filename.jpg">无法访问图片地址。网上查看资料收到一个网友提醒，将项目的out目录直接配置到tomat的webapp下就可以解决。因此我也采用这种方式尝试，果然可行。修改的配置如下：
* 1.将File->Project Structure->Project->Project compiler output：*/apache-tomcat-7.0.81/webapps/项目名
* 2.将File->Project Structure->Artifacts->Output directory:*/apache-tomcat-7.0.81/webapps/项目名
这样一来idea编译，发布的文件就直接到tomcat的webapp下了，就可以采用之前的方式对图片进行访问