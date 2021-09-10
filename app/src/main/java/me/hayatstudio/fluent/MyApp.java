package me.hayatstudio.fluent;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import org.acra.ACRA;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.MailSenderConfigurationBuilder;
import org.acra.config.ToastConfigurationBuilder;
import org.acra.data.StringFormat;

public class MyApp
    extends Application
{
    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        // ACRA core config
        CoreConfigurationBuilder confbuilder = new CoreConfigurationBuilder(this);
        confbuilder
            .withBuildConfigClass(BuildConfig.class)
            .withReportFormat(StringFormat.KEY_VALUE_LIST);
        // ACRA Toast plugin config
        confbuilder.getPluginConfigurationBuilder(ToastConfigurationBuilder.class)
            .withEnabled(true)
            .withResText(R.string.crash_message)
            .withLength(Toast.LENGTH_LONG);
        // ACRA Mail plugin config
        confbuilder.getPluginConfigurationBuilder(MailSenderConfigurationBuilder.class)
            .withEnabled(true)
            .withReportAsFile(true)
            .withReportFileName("crash_report.txt")
            .withSubject("Fluent App");
        ACRA.init(this, confbuilder);
    }
}
