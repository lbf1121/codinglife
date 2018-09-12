##How to create your first Web Automated test | Selenium with Java
如何使用Selenium创建第一个java自动测试用例，文章以登录linkedin为例
* 第一步安装jdk8
* 第二步安装IDE：IntelliJ IDEA
* 第三步创建一个Maven项目
* 第四步引入Selenium库
* * 打开pom.xml文件，<project></project>中添加一下代码
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>2.53.1</version>
    </dependency>
</dependencies>
```
最终文件为：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.TestSample</groupId>
    <artifactId>SampleProject</artifactId>
    <version>1.0-SNAPSHOT</version>
    <!-- 添加selenium库 -->
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>2.53.1</version>
        </dependency>
    </dependencies>
</project>
```
如果Maven无法找到Selenium库，请在terminal终端输入：
```
    mvn clean install -U
```
* 第五步创建一个自动化测试用例
```Java
public class Nameofclass {
    public static void main(String[] args){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com");
        driver.findElement(By.id("login-email")).sendKeys("random-email@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("12345678");
        driver.findElement(By.id("login-submit")).click();
    }
}
```

[How to create your first Web Automated test（原文）](https://medium.com/@kalsinirch/simple-web-automation-flow-creating-13486ba1ef4)