## 为什么需要ScannerUtils？
* 添加依赖，一行代码快速集成二维码/条形码扫描。
* 针对扫码识别速度慢做了一些优化，识别速度比Zxing快很多。
* 解码库Zbar与Zxing融合。
* 定制部分：WebView工具类。

## 说明：
* 为了提高扫码速度，条形码只集成了EAN_13和CODE_128两种比较常用的编码格式。
* 扫码工具类：CaptureActivity。WebView工具类: WebViewActivity。

##   以下是ScannerUtils的集成、使用教程:
Step 1.先在 build.gradle(Project:XXXX) 的 repositories 添加:
```javascript
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  Step 2. 然后在 build.gradle(Module:app) 的 dependencies 添加:
  ```javascript
  dependencies {
  		implementation 'com.github.ljw124:ScannerUtils:1.0.8'
	}
	
```
## 扫码工具类示例（使用WebView工具类此部分忽略）  
  Step 3. 在需要扫码时调用(一般是点击扫码图标):
  ```javascript
  startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), CaptureActivity.REQUEST_CODE);
  ```
  
  step 4. 在onActivityResult方法中接收扫码识别的结果:
  ```javascript
  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CaptureActivity.REQUEST_CODE && resultCode == CaptureActivity.RESULT_CODE && null != data) {
            Bundle extras = data.getExtras();
            String msg = extras.getString("msg").trim();
        }
    }
   ```
   
 ## WebView工具类示例-这部分是定制功能（使用扫码工具类此部分忽略）  
 Step 5. 在使用定制WebView工具类时调用(如点击按钮):
 ```javascript
Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
intent.putExtra("url", "http://10.25.195.38:8080/test.html");
intent.putExtra("type", "cancel"); //请求类型
//下面是请求参数，传序列化对象
String params = "{\"age\":\"28\",\"sex\":\"男\"}";
PersonBean request = GsonUtil.deser(params, PersonBean.class);
Bundle bundle = new Bundle();
bundle.putSerializable("params", request);
intent.putExtras(bundle);
startActivityForResult(intent, WebViewActivity.REQUEST_CODE);
```

 Step 6. 在onActivityResult方法中接收WebView页面返回的结果:
 ```javascript
 @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == WebViewActivity.REQUEST_CODE && resultCode == WebViewActivity.RESULT_CODE && null != data) {
            Bundle extras = data.getExtras();
            String result = extras.getString("result").trim();
	    String requestType = extras.getString("type").trim(); // payment-支付，cancel-冲销
            if (("payment").equals(requestType)) {
                paymentResponse = GsonUtil.deser(result, PersonBean.class);
            } else if ("cancel".equals(requestType)) {
                cancleResponse = GsonUtil.deser(result, GoodsBean.class);
            }
            tvMsg.setText(result);
        }
    }
 ```
 
 
