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

        // configure ACRA crash reporting
        CoreConfigurationBuilder confbuilder = new CoreConfigurationBuilder(this);
        confbuilder
            .withBuildConfigClass(BuildConfig.class)
            .withReportFormat(StringFormat.KEY_VALUE_LIST);
        confbuilder.getPluginConfigurationBuilder(ToastConfigurationBuilder.class)
            .withEnabled(true)
            .withResText(R.string.acra_crash_message)
            .withLength(Toast.LENGTH_LONG);
        confbuilder.getPluginConfigurationBuilder(MailSenderConfigurationBuilder.class)
            .withEnabled(true)
            .withReportAsFile(true)
            .withReportFileName(getString(R.string.acra_filename))
            .withMailTo(getString(R.string.acra_email_address))
            .withSubject(getString(R.string.acra_email_subject))
            .withBody(getString(R.string.acra_email_body));
        ACRA.init(this, confbuilder);
    }

}
