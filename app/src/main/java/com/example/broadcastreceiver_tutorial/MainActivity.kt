package com.example.broadcastreceiver_tutorial

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //리시버 객체 생성
        receiver = ExampleBroadCastReceiver()
    }

    override fun onResume() {
        super.onResume()
        //인텐트 중 해당 액션이 발생했다면 receiver에 인텐트를 전달.
        with(IntentFilter()) {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            registerReceiver(receiver, this)
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }
}

/*BroadCastReceiver
안드로이드의 4대 컴포넌트 중 하나.
게시-구독 디자인 패턴과 비슷하게 브로드캐스트 메시지를 받거나 보낼 수 있음.
관심 있는 이벤트가 발생할 때 이러한 브로드캐스트가 전송됨.(예를 들어 충전, 부팅 등)
앱은 맞춤 브로드캐스트를 전송해 다른 앱이 관심을 가질만한 사항(일부 새 데이터 다운로드 정보)을 관련 앱에 알릴 수 있음.
앱은 특정 브로드캐스트를 수신하도록 등록할 수 있음. 브로드캐스트가 전송되면 시스템은 특정 유형의 브로드캐스트를 수신하도록
신청한 앱에 브로드캐스트를 자동으로 라우팅함.
일반적으로 브로드캐스트는 앱 전체에 걸쳐 그리고 일반 사용자 플로우 외부에서 메시징 시스템으로 사용할 수 있음.
그러나 백그라운드 시스템 성능 저하의 원인이 될 수 있는 작업을 실행하는 기회를 남용하지 않도록 주의해야 함.
 */

/*대표적인 브로드캐스트
ACTION_BOOT_COMPLETED: 부팅이 끝났을 때
ACTION_CAMERA_BUTTON: 카메라 버튼이 눌렸을 때
ACTION_DATE_CHANGED
ACTION_TIME_CHANGED: 날짜, 시간이 수동으로 변했을 때
ACTION_SCREEN_OFF
ACTION_SCREEN_ON: 화면이 켜질 때, 꺼질 때
ACTION_AIRPLANE_MODE_CHANGED: 비행기 모드가 바꼈을 때
ACTION_PACKAGE_ADDED
ACTION_PACKAGE_CHANGED
ACTION_PACKAGE_DATA_CLEARED
ACTION_PACKAGE_INSTALL
ACTION_PACKAGE_REMOVED
ACTION_PACKAGE_REPLACED
ACTION_PACKAGE_RESTARTED: 앱 설치/제거
ACTION_POWER_CONNECTED
ACTION_POWER_DISCONNECTED: 충전
ACTION_REBOOT
ACTION_SHUTDOWN: 부팅, 종료
ACTION_TIME_TICK: 매
android.provider.Telephony.SMS_RECEIVED: SMS 수신 (RECEIVE_SMS 권한 필요)
 */