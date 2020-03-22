### Hibernate Validator 

>Hibernate Validator是SpringBoot内置的校验框架，只要集成了SpringBoot就自动集成了它，我们可以通过在对象上面使用它提供的注解来完成参数校验。

> 我们先来了解下常用的注解，对Hibernate Validator所提供的校验功能有个印象。

- @Null：被注释的属性必须为null；
- @NotNull：被注释的属性不能为null；
- @AssertTrue：被注释的属性必须为true；
- @AssertFalse：被注释的属性必须为false；
- @Min：被注释的属性必须大于等于其value值；
- @Max：被注释的属性必须小于等于其value值；
- @DecimalMin(value)    被注释的元素必须是一个数字，其值必须大于等于指定的最小值
- @DecimalMax(value)    被注释的元素必须是一个数字，其值必须小于等于指定的最大值
- @Size(min,max)：被注释的属性必须在其min和max值之间；
- @Pattern：被注释的属性必须符合其regexp所定义的正则表达式；
- @NotBlank：被注释的字符串不能为空字符串；
- @NotEmpty：被注释的属性不能为空；
- @Email：被注释的属性必须符合邮箱格式
- @自定义错误注解: com.summer.validation.controller.annotations
