@echo on
REM Examples
REM java2ws -wsdl -d ./resource org.apache.hello.Greeter
REM java2ws -cp ./tmp org.apache.hello.Greeter -wsdl 
REM java2ws -o hello.wsdl -wsdl org.apache.hello.Greeter 
REM java2ws -client -server -s ./src org.apache.hello.Greeter
REM java2ws -wrapperbean -classdir ./classes org.apache.hello.Greeter

REM com.talend.se.demo.twt Ping
REM dist\ping.jar

REM call c:\Talend\5.3.1\esb\bin\java2ws  -wsdl                   -o arin_embedded.wsdl -cp dist/ping.jar                                   com.talend.se.demo.twt.Arin
REM call c:\Talend\5.3.1\esb\bin\java2ws  -wsdl -createxsdimports -o arin.wsdl          -cp dist/ping.jar                                   com.talend.se.demo.twt.Arin
call c:\Talend\5.3.1\esb\bin\java2ws  -wsdl                   -o arin_embedded.wsdl -cp dist/ping.jar -t http://twt.demo.se.talend.com/ com.talend.se.demo.twt.Arin
call c:\Talend\5.3.1\esb\bin\java2ws  -wsdl -createxsdimports -o arin.wsdl          -cp dist/ping.jar -t http://twt.demo.se.talend.com/ com.talend.se.demo.twt.Arin
copy *.xsd src\com\talend\se\demo\twt
