package com.example.broadcastreceiver_tutorial

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

//커스텀 브로드캐스트 리시버
class ExampleBroadCastReceiver : BroadcastReceiver() {

    val action = "com.example.broadcastreceiver_tutorial.ACTION_EXAMPLE_BROADCAST"

    override fun onReceive(context: Context, intent: Intent) {
        // 이 메소드는 브로드캐스트 리시버가 인텐트 브로드캐스트를 수신받았을 때 호출된다.
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.action)) {
            Toast.makeText(context, "전원 연결됨", Toast.LENGTH_SHORT).show()
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.action)) {
            Toast.makeText(context, "전원 연결 해제 됨", Toast.LENGTH_SHORT).show()
        }
    }
}