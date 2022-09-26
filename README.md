## 为什么需要ScannerUtils？
* 添加依赖，一行代码快速集成二维码/条形码扫描。
* 针对扫码识别速度慢做了一些优化，识别速度比Zxing快很多。
* 解码库Zbar与Zxing融合

## 说明：
* 为了提高扫码速度，条形码只集成了EAN_13和CODE_128两种比较常用的编码格式。

##   以下是ScannerUtils的集成、使用教程，如果有不清楚的地方可以下载demo看看:
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
  		implementation 'com.github.ljw124:ScannerUtils:1.0.3'
	}
	
```
## 扫码工具类示例  
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
   
 ## WebView工具类示例-这部分是定制功能
 Step 5. 在使用定制WebView工具类时调用(如点击按钮):
 ```javascript
Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
intent.putExtra("url", "http://vouchertest.bpsinopec.com/voucher-web-app-test/test.html");
intent.putExtra("type", "cancel"); //请求类型
//下面是请求参数，传HdPayMentRequest对象或HdPayCancle对象
String params = "{\"newOrderNumber\":\"3211a220829144151\",\"oldOrderNumber\":\"3211a220829144059\"}";
HdPayCancle request = GsonUtil.deser(params, HdPayCancle.class);
Bundle bundle = new Bundle();
bundle.putSerializable("params", request);
intent.putExtras(bundle);
startActivityForResult(intent, WebTestActivity.REQUEST_CODE);
```

 Step 6. 在onActivityResult方法中接收WebView页面返回的结果:
 ```javascript
 @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == WebTestActivity.REQUEST_CODE && resultCode == WebTestActivity.RESULT_CODE && null != data) {
            Bundle extras = data.getExtras();
            String result = extras.getString("result").trim();
	    String requestType = extras.getString("type").trim(); // payment-支付，cancel-冲销
            if (("payment").equals(requestType)) {
                paymentResponse = GsonUtil.deser(result, FinishPaymentResponse.class);
            } else if ("cancel".equals(requestType)) {
                cancleResponse = GsonUtil.deser(result, PayMentCancleResponse.class);
            }
            tvMsg.setText(result);
        }
    }
 ```
 
 
