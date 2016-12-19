# mapstruct 

## 简介

mapstuct是一款代码生成器，为JavaBean之间转换提供了一种简易，快捷易懂的转换方式，提高代码的可读性和清晰度，减少Java程序员在常用业务，例如Bo，Do，Vo，Mo等bean类型转换，大量set，get操作。

## 使用方法

mapstruct采用注解方式，见demo

### 使用注意事项

1. 1.1.0版本的bean访问器必须采用set，get作为前缀，如需更改前缀需要扩展采用spi方式重写_org.mapstruct.ap.spi.AccessorNamingStrategy_类，覆盖_isSetterMethod_,_isGetterMethod_,_getPropertyName_方法

2. 1.1.0版本 jdk1.8环境依赖：

   ```
               <dependency>
                   <groupId>org.mapstruct</groupId>
                   <artifactId>mapstruct-jdk8</artifactId>
                   <version>1.1.0.Final</version>
               </dependency>

   ```

   ​