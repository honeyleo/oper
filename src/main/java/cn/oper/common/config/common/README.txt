概要：BaseConfig采用反射机制,将其子类中的成员变量与*.properties、*.xml文件中的KEY值进行映射。
	  使得配置共用参数更加灵活与简便。
使用说明：
1. *.properties、*.xml文件中的KEY或节点名只能使用'_'做单词之间的连接符,如：jdbc_url 或 jdbcUrl、jdbcurl、JDBCURL.
        而代码中的成员变量必须为驼峰形式,如：jdbcUrl
        
2. BaseConfig子类中的成员变量的修饰符必须为：private static *