# 项目说明

## 1、主要功能

	SpringMVC文件上传和下载
## 2、主要知识点
### （1）上传功能的注意点
```java
表单form上面需加enctype="multipart/form-data";
控制层方法参数添加MultipartFile file和Http ServletRequest request参数且file这个变量名要和表单的name值一致。
```
### （2）上传的步骤
	添加依赖；
	配置文件编写；
	添加表单；
	控制层代码的编写；
	上传测试。
### （3）控制层核心步骤
	获取文件名 ；
	对文件进行处理，比如生成随机文件名：a.获取文件后缀名；b.生成随机文件名。
	获取存放文件的物理路径；
	创建文件实例；
	写入文件。
### （4）下载功能的注意点
```java
针对中文文件名的下载注意字符编码和转换：filename=new String(filename.getBytes("GBK"),"ISO-8859-1");
```
### （5）下载的步骤

    准备页面编写下载表单或链接项；
    控制层代码编写；
    下载测试。
## 3、说明
### （1）配置支持文件上传的Bean的Class位置为：
	Maven Dependencies→spring-web-5.2.4.RELEASE.jar→org.springframework.web.multipart.commons.CommonsMultipartResolver.class
### （2）上传文件失败
	一般解决办法，看配置文件中的Bean是否缺失id。
### （3）file一致
```java
index.jsp中name=file中的file和FileOpController.java中的MultipartFile file中的file要保持一致。
```
### （4）对下载功能注意点中的编码说明
    "GBk"指编译器的编码。
## 4、报错
### 出现：严重: Allocate exception for servlet [mvc]
	解决办法：web.xml中出错，可能为单词写错
### 出现找不到路径
    解决方法：下载文件后的路径要加上“/”。
## 5、附加
### 依赖
```java
<!-- spring-webmvc依赖 -->
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.4.RELEASE</version>
</dependency>
    
<!-- commons-fileupload依赖 -->
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.4</version>
</dependency
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.6</version>
</dependency>
```
###  JDK8API
```html
https://docs.oracle.com/javase/8/docs/api/
```