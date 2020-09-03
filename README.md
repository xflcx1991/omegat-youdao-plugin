# OmegaT 有道翻译插件
一个能让 OmegaT 从有道翻译获取机器翻译的插件。官方没有提供测试 Key，必须先申请再配置使用。使用方法见下方。

已在 OmegaT 4.3.2 和 gradle 3.0 环境下测试通过。

参考了以下项目的代码，把我从黑箱带入 OmegaT 插件开发，感谢各位作者。
> https://github.com/yoyicue/omegat-tencent-plugin
> https://github.com/omegat-org/omegat/blob/854b6b5a66a0306e5c27e74c0b5d656ed80b2bd4/src/org/omegat/core/machinetranslators/YandexTranslate.java
> GoogleTranslateWithoutApiKey

特别感谢 [@Ninty](https://github.com/c19354837 "Ninty") 介绍的 Gson 和 OkHttp 用来处理数据。不过后来发现只需要一个很小子集的功能，也为了减小生成 jar 包的大小，工具包改为了 Hutool。

关于 OmegaT 插件项目开发环境配置和开发相关资料请参见我的另一个 OmegaT 彩云小译插件项目的 [readme](https://gitee.com/xffish/omegat-caiyun-interpreter-plugin)。

## 使用方法
1. 创建应用。登录[有道智云平台](https://ai.youdao.com/login.s)后，点击“应用管理”->“我的应用”->“创建应用”，根据提示信息，完成应用创建。 在创建应用时请选择“API”， 应用创建成功后您可获取应用ID（appKey）和应用密钥等信息。创建是即时开通的，下同。
2. 创建翻译实例。登录上述平台后，点击“自然语言翻译”->“翻译实例”->“创建实例”，根据提示信息，完成实例创建。创建实例时请选择实例类型为“文本翻译”。实例创建成功后需要点击实例列表最后一列的“绑定应用”，根据弹出窗口选择上一步创建的应用即可。
3. 下载 releases 里的 zip，解压得到 jar 文件和别的插件一样放进 OmegaT 插件目录。这个目录默认应该在 OmegaT 安装目录下的`plugins`文件夹
4. 打开 OmegaT，选项——首选项——机器翻译，选中`Youdao Translate`，点击配置，然后填入第一步得到应用ID和应用密钥，最后勾选启用，点确定关闭首选项窗口。
5. 没有第 5 步，做完上面 4 步，打开你的翻译项目，你应该能在机器翻译面板看到来自有道翻译的结果了。Enjoy it!

## 自行编译
1. 克隆本项目，进入项目根目录，然后运行`./gradlew build`。
2. 在`build/libs/`目录下，拷贝`omegat-youdao-plugin-*.jar`文件到 OmegaT 的插件目录。

## 许可证
本项目采用[木兰宽松许可证, 第2版](https://license.coscl.org.cn/MulanPSL2/)
本项目采用了以下第三方组件：
* [Hutool](https://hutool.cn/) 5.4.0（木兰宽松许可证, 第2版）

---
注意！！！
> 有道智云平台不像彩云小译一样在低频率使用下一直免费。有道的方式是注册就提供 50 元体验金，另外在[价格中心](https://ai.youdao.com/price-center.s)最下面有两个微信客服二维码，任选其一添加后会再送 50 元体验金。这样一共 100 元的体验金，会按照 48元/百万字符的标准扣费，即使没到百万字符，也是按照用多少扣多少。所以最终该平台还是要收费的，不过能用就用嘛。
