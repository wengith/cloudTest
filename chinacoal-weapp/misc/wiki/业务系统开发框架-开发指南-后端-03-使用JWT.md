## 1.JWT是什么

JWT(json web token)是为了在网络应用环境间传递声明而执行的一种基于JSON的开放标准。

JWT的声明一般被用来在身份提供者和服务提供者间传递被认证的用户身份信息，以便于从资源服务器获取资源。比如用户登录。

## 2.基于session的登录认证

在传统的用户登录认证中，因为http是无状态的，所以都是采用session方式。用户登录成功，服务端会保存一个session，服务端会返回给客户端一个sessionId，客户端会把sessionId保存在cookie中，每次请求都会携带这个sessionId。

cookie+session这种模式通常是保存在内存中，而且服务从单服务到多服务会面临的session共享问题。虽然目前存在使用Redis进行Session共享的机

制，但是随着用户量和访问量的增加，Redis中保存的数据会越来越多，开销就会越来越大，多服务间的耦合性也会越来越大，Redis中的数据也很难进行

管理，例如当Redis集群服务器出现Down机的情况下，整个业务系统随之将变为不可用的状态。

而JWT不是这样的，只需要服务端生成token，客户端保存这个token，每次请求携带这个token，服务端认证解析就可。

## 3.JWT Token样例
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmciOiLku4rml6XlpLTmnaEiLCJuYW1lIjoiRnJlZeeggeWGnCIsImV4cCI6MTUxNDM1NjEwMywiaWF0IjoxNTE0MzU2MDQzLCJhZ2UiOiIyOCJ9.49UF72vSkj-sA4aHHiYN5eoZ9Nb4w5Vb45PsLF7x_NY

## 4.JWT的结构

第一部分我们称它为头部（header),第二部分我们称其为载荷（payload)，第三部分是签证（signature)。

### header

jwt的头部承载两部分信息：

**声明类型**，这里是jwt

**声明加密的算法** 通常直接使用 HMAC SHA256

完整的头部就像下面这样的JSON：
{

"typ": "JWT",

"alg": "HS256"

}

然后将头部进行base64加密（该加密是可以对称解密的),构成了第一部分：

eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9

### playload

载荷就是存放有效信息的地方。这个名字像是特指飞机上承载的货品，这些有效信息包含三个部分

* 标准中注册的声明

* 公共的声明

* 私有的声明

1) 标准中注册的声明 (建议但不强制使用) ：

* iss: jwt签发者

* sub: jwt所面向的用户

* aud: 接收jwt的一方

* exp: jwt的过期时间，这个过期时间必须要大于签发时间

* nbf: 定义在什么时间之前，该jwt都是不可用的.

* iat: jwt的签发时间

* jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。

2)公共的声明 ：

公共的声明可以添加任何的信息，一般添加用户的相关信息或其他业务需要的必要信息.但不建议添加敏感信息，因为该部分在客户端可解密.

3)私有的声明 ：

私有声明是提供者和消费者所共同定义的声明，一般不建议存放敏感信息，因为base64是对称解密的，意味着该部分信息可以归类为明文信息。

定义一个payload：

{

"name":"Free码农",

"age":"28",

"org":"今日头条"

}

然后将其进行base64加密，得到Jwt的第二部分：

eyJvcmciOiLku4rml6XlpLTmnaEiLCJuYW1lIjoiRnJlZeeggeWGnCIsImV4cCI6MTUxNDM1NjEwMywiaWF0IjoxNTE0MzU2MDQzLCJhZ2UiOiIyOCJ9

### signature

jwt的第三部分是一个签证信息，这个签证信息由三部分组成：

header (base64后的)

payload (base64后的)

secret

这个部分需要base64加密后的header和base64加密后的payload使用.连接组成的字符串，然后通过header中声明的加密方式进行加盐secret组合加密，然后就构成了jwt的第三部分：

49UF72vSkj-sA4aHHiYN5eoZ9Nb4w5Vb45PsLF7x_NY

密钥secret是保存在服务端的，服务端会根据这个密钥进行生成token和验证，所以需要保护好。

## 5.在框架里的使用方式
认证流程架构图

![认证流程](http://git.jsptz.com/cloud/pictures/raw/master/%E6%97%A0%E7%8A%B6%E6%80%81%E6%A8%A1%E5%9E%8B.png)

说明如下：

1.JWT是在用户登录时，由网关进行登录信息校验通过后生成的，并将生成的JWT返回给前端。

2.前端将生成的JWT保存在localStorage中，每次请求后台服务时，会在请求的Header信息中携带Jwt的信息，别名为Authorization

3.网关会对JWT中携带的信息进行验证，包括是否是合法的验证信息、用户是否存在、是否在有效期范围内。

4.微服务无论请求有多少层，默认会将JWT的信息在header中进行传递，也就是说每个微服务都能获得jwt的信息。

5.通过提供的JwtTokenUtil类，可对token进行生成和解密，并可取到携带的用户信息。例如用户代码、机构代码等。

**集成和使用说明如下**

* 添加依赖

```
<ins-framework-auth.version>6.0.15-SNAPSHOT</ins-framework-auth.version>
<dependency>
    <groupId>ins.framework</groupId>
    <artifactId>ins-framework-auth</artifactId>
    <version>${ins-framework-auth.version}</version>
    <exclusions>
        <exclusion>
            <groupId>ins.framework</groupId>
            <artifactId>ins-framework-mybatis</artifactId>
        </exclusion>
        <exclusion>
            <groupId>ins.framework</groupId>
            <artifactId>ins-framework-web</artifactId>
        </exclusion>
        <exclusion>
            <groupId>ins.framework</groupId>
            <artifactId>
                ins-framework-mybatis-generator
            </artifactId>
        </exclusion>
    </exclusions>
</dependency>
```
* 登录模块代码

请参考ins-framework-auth包里的ins.platform.auth.jwt.api.JwtAuthApi类，登录逻辑代码如下：

@ApiOperation("登录验证获得token")
	@RequestMapping(value = "/oauth", method = RequestMethod.POST)
	public ApiResponse auth(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) throws Exception{
		ApiResponse result = new ApiResponse();
		Map<String,String> data = new HashMap<String,String>();
		SysUser user = sysUserService.findByUserCode(username);
		if (null == user) {
			result.setStatus(500);
			result.setStatusText("用户不存在");
			result.setData(data);
			return result;
		}
		if (!"1".equalsIgnoreCase(user.getValidStatus())) {
			result.setStatus(500);
			result.setStatusText("用户是无效用户");
			result.setData(data);
			return result;
		}
		Date now = new Date();
		if (now.after(user.getPasswordExpireDate())) {
			result.setStatus(500);
			result.setStatusText("用户密码已过期");
			result.setData(data);
			return result;
		}
		if (now.before(user.getPasswordSetDate())) {
			result.setStatus(500);
			result.setStatusText("用户尚未激活");
			result.setData(data);
			return result;
		}
		String passWord = user.getPassword();
		passWord = passWord == null ? "" : passWord.toUpperCase();
		if(EncryptUtils.encrypt(password).equals(passWord)){
			Map<String,Object> props = new HashMap<String,Object>();
			props.put("com_code","000000");
			String token = authService.generateToken(user,props);
			data.put("token", token);
			data.put("usertype",(user.getUserType()).toString()); 
			data.put("username", user.getUserName()); 
			data.put("nickname", user.getUserName());
			result.setData(data);
			result.setStatus(200);
			return result;
		}
		else{
			result.setStatus(500);
			result.setStatusText("密码错误");
			result.setData(data);
			return result;
		}
	}
使用者可以将需要在Jwt中携带的信息填进去，例如com_code:
```
  Map<String,Object> props = new HashMap<String,Object>();
  props.put("com_code","000000");
  String token = authService.generateToken(user,props);
```
* 微服务取jwt携带的属性值

注入JwtTokenUtil
```
@Autowired
JwtTokenUtil jwtTokenUtil;
```
调用方法jwtTokenUtil.getAttribute("com_code");即可

例如
```
    @Autowired
	JwtTokenUtil jwtTokenUtil;
	@ApiOperation(value = "查找用户对象")
	@RequestMapping(value = "/search", method = { RequestMethod.POST })
	public ApiResponse search(HttpServletRequest request, @ModelAttribute SysUser sysUser) {
		System.out.println(jwtTokenUtil.getAttribute("com_code"));
		ResultPage<SysUserVo> result = userService.findForDataTables(sysUser);
		// 4.返回处理结果
		return new ApiResponse(result);
	}
```

* 其它注意事项
  
  1）微服务启动类中要包含如下代码：
  ```
  @Bean
	Client feignClient(CachingSpringLoadBalancerFactory cachingFactory, SpringClientFactory clientFactory) {
		return new LoadBalancerFeignClient(new Client.Default(null, null), cachingFactory, clientFactory);
	}

	@Bean
	@Primary
	public Feign.Builder feignBuilder() {
		return Feign.builder().requestInterceptor(new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate requestTemplate) {
				ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpServletRequest request = attributes.getRequest();
				Enumeration<String> headerNames = request.getHeaderNames();
				if (headerNames != null) {
					while (headerNames.hasMoreElements()) {
						String name = headerNames.nextElement();
						String values = request.getHeader(name);
						System.err.println(String.format("name = {%s} ,value = {%s}", name, values));
						requestTemplate.header(name, values);
					}
				}
			}
		});
	}
  ```
  2）JwtTokenUtil接口方法说明
  ```
  /**
     * 获得jwt中的内容
     * @param attribute 属性名
     * @return
     */
    public Object getAttribute(String attribute);
    
    
   /**
     * 根据用户信息生成token
     * @param user 用户信息
     * @param props 其它属性信息
     * @return
     */
    public String generateToken(SysUser user,Map<String, Object> props);
    
   /**
     * 获得当前登录用户的代码
     * @return
     */
    public String getUserCode();
     
  ```
    
  
