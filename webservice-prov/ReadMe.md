#### 在浏览器地址栏输入以下地址就可以看到该service的详细信息!

		http://localhost:9001/Service/Function?wsdl 
#### 打开cmd输入以下命令:wsimport -s src的路径 -p 完整包名 -keep webservice的发布地址导入WebService类

		wsimport -s F:\\MichaelDuan\\Eclipse\\eclipse_workspace\\webservice-cons\\src -p com.cons.service http://localhost:9100/Service/Function?wsdl
#### webService是使用soap协议而不是Http协议