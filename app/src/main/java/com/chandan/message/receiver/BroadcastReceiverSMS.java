package com.chandan.message.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.chandan.message.database.DatabaseHelper;
import com.chandan.message.database.Messages;
import com.chandan.message.database.Notices;
import com.chandan.message.recycler_view.MesssageRecyclerViewAdapter;
import com.chandan.message.recycler_view.NoticesRecyclerViewAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BroadcastReceiverSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] smsObj = (Object[]) bundle.get("pdus");

        for(Object sms : smsObj){
            SmsMessage message = SmsMessage.createFromPdu((byte[]) sms);
            // Fetching data from sms
            String smsSender = message.getOriginatingAddress().toString();
            String smsBody = message.getDisplayMessageBody().toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLL dd, KK:mm aaa");
            String dateTime = simpleDateFormat.format(new Date(message.getTimestampMillis()));

//            Pattern pattern = Pattern.compile("[\\+][0-9]{10,}+");
//            Matcher matcher = pattern.matcher(smsSender);

            if(Pattern.matches("[\\+][0-9]{10,}+",smsSender)){
                try{
                    DatabaseHelper.getInstance(context).messageDAO().insertMessage(
                            new Messages(dateTime,smsSender,smsBody)
                    );
                    MesssageRecyclerViewAdapter.getAdapter(context).notifyDataSetChanged();
                }catch (RuntimeException e){
                    Log.e("exception",e.toString());
                }
            }else{
                DatabaseHelper.getInstance(context).noticesDAO().insertNotices(
                        new Notices(dateTime,smsSender,smsBody)
                );
                NoticesRecyclerViewAdapter.getAdapter(context).notifyDataSetChanged();
            }
            Log.d("SMSReceived","Mobile no: " + smsSender + " Message :" + smsBody +" Time: " +dateTime);

      }
    }
}
