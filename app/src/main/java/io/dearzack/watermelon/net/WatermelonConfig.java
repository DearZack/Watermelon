package io.dearzack.watermelon.net;

import android.content.Context;

import com.yanzhenjie.andserver.annotation.Config;
import com.yanzhenjie.andserver.framework.config.Multipart;
import com.yanzhenjie.andserver.framework.config.WebConfig;
import com.yanzhenjie.andserver.framework.website.AssetsWebsite;
import com.yanzhenjie.andserver.framework.website.StorageWebsite;

import java.io.File;

/**
 * PC和模拟器通信
 * 文件 C:\\Users\\user\\.emulator_console_auth_token
 * auth **********   （********** 为/emulator_console_auth_token的内容，这也redir命令才会有）
 *
 * redir add tcp:12333:12333
 * redir list
 * redir del tcp:12333
 *
 */

@Config
public class WatermelonConfig implements WebConfig {

    @Override
    public void onConfig(Context context, Delegate delegate) {
        delegate.addWebsite(new AssetsWebsite(context, "/web"));
//        delegate.addWebsite(new StorageWebsite( "/web"));

        delegate.setMultipart(Multipart.newBuilder()
                .allFileMaxSize(1024 * 1024 * 20) // 20M
                .fileMaxSize(1024 * 1024 * 5) // 5M
                .maxInMemorySize(1024 * 10) // 1024 * 10 bytes
                .uploadTempDir(new File(context.getCacheDir(), "_server_upload_cache_"))
                .build());
    }
}
