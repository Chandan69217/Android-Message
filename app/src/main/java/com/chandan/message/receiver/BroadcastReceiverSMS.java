package com.chandan.message.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.chandan.message.database.DatabaseHelper;
import com.chandan.message.database.Messages;
import com.chandan.message.recycler_view.MesssageRecyclerViewAdapter;

public class BroadcastReceiverSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] smsObj = (Object[]) bundle.get("pdus");

        for(Object sms : smsObj){
            SmsMessage message = SmsMessage.createFromPdu((byte[]) sms);
            String mobileNo = message.getOriginatingAddress().toString();
            String smsBody = message.getDisplayMessageBody().toString();
            Log.d("SMSReceived","Mobile no: " + mobileNo + " Message :" + smsBody);
            try{
                DatabaseHelper.getInstance(context).messageDAO().insertMessage(
                        new Messages(2,mobileNo,smsBody)
                );
                MesssageRecyclerViewAdapter.getAdapter(context).notifyDataSetChanged();
            }catch (RuntimeException e){
                Log.e("exception",e.toString());
            }
      }
    }
}
