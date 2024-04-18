package com.example.applemarket

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ActivityMainBinding
import java.lang.System.exit

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("정말 종료하시겠습니까?")
        builder.setCancelable(false)
        builder.setIcon(R.drawable.ic_chat)
        builder.setPositiveButton("확인") {dialog, _ ->
            finish()
        }
        builder.setNegativeButton("취소") {dialog, _ ->

        }
        builder.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 툴바 제거 코드
        supportActionBar?.hide()

        // 구분선 추가
        val recyclerView = binding.recyclerView
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        binding.btnNotification.setOnClickListener {
            notification()
        }

        // 데이터 추가
        val itemList = ArrayList<ItemInfo>()
        itemList.add(
            ItemInfo(
                img = R.drawable.sample1,
                name = "산진 한달된 선풍기 팝니다",
                info = "이사가서 필요가 없어졌어요 급하게 내놓습니다",
                seller = "대현동",
                price = 1000,
                locate = "서울 서대문구 창천동",
                heart = 13,
                chat = 25
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample2,
                name = "김치냉장고",
                info = "이사로 인해 내놔요",
                seller = "안마담",
                price = 20000,
                locate = "인천 계양구 귤현동",
                heart = 8,
                chat = 28
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample3,
                name = "샤넬 카드지갑",
                info = "고퀄지갑이구요\n사용감이 있어서 싸게 내어둡니다",
                seller = "코코유",
                price = 10000,
                locate = "수성구 범어동",
                heart = 23,
                chat = 5
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample4,
                name = "금고",
                info = "금고\n떼서 가져가야함\n대우월드마크센텀\n미국이주관계로 싸게 팝니다",
                seller = "Nicole",
                price = 10000,
                locate = "해운대구 우제2동",
                heart = 14,
                chat = 17
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample5,
                name = "갤럭시Z 플립3 팝니다",
                info = "갤럭시Z 플립3 그린 팝니다\n항시 케이스 씌워서 썻고 필름 한장챙겨드립니다\n화면에 살짝 스크래치난거 말고 크게 이상은 없습니다!",
                seller = "절명",
                price = 150000,
                locate = "연제구 연산제8동",
                heart = 22,
                chat = 9
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample6,
                name = "프라다 복조리백",
                info = "까임 오염없고 상태 깨끗합니다\n정품여부모름",
                seller = "미니멀하게",
                price = 50000,
                locate = "수원시 영통구 원천동",
                heart = 25,
                chat = 16
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample7,
                name = "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
                info = "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\n2. 장소: 북구 블루마시티, 32-33층\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\n6. 고기 굽기 가능\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\n8. 층간소음 주의 부탁드립니다.\n9. 방3개, 화장실3개, 비데 3개\n10. 저희 집안이 쓰는 별장입니다. 울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\n2. 장소: 북구 블루마시티, 32-33층\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\n6. 고기 굽기 가능\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\n8. 층간소음 주의 부탁드립니다.\n9. 방3개, 화장실3개, 비데 3개\n10. 저희 집안이 쓰는 별장입니다.",
                seller = "굿리치",
                price = 150000,
                locate = "남구 옥동",
                heart = 142,
                chat = 54
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample8,
                name = "샤넬 탑핸들 가방",
                info = "샤넬 트랜디 CC 탑핸들 스몰 램스킨 블랙 금장 플랩백 !\n 색상: 블랙\n사이즈: 25.5cm * 17.5cm * 8cm\n구성: 본품, 더스트\n급하게 돈이 필요해서 팝니다 ㅠ ㅠ,,",
                seller = "난쉽",
                price = 180000,
                locate = "동래구 온천제2동",
                heart = 31,
                chat = 7
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample9,
                name = "4행정 엔진분무기 판매합니다",
                info = "3년전에 사서 한번 사용하고 그대로 둔 상태입니다. 요즘 사용은 안해봤습니다. 그래서 저렴하게 내놓습니다. 중고라 반품은 어렵습니다\n",
                seller = "알뜰한",
                price = 30000,
                locate = "원주시 명륜2동",
                heart = 7,
                chat = 28
            )
        )
        itemList.add(
            ItemInfo(
                img = R.drawable.sample10,
                name = "셀린느 버킷 가방",
                info = "22년 신세계 대전 구매입니당\n셀린느 버킷백\n구매해서 몇번사용했어요\n까짐 스크래치 없습니다\n타지역에서 보내는 거라 택배로 진행합니당!",
                seller = "똑태현",
                price = 190000,
                locate = "중구 동화동",
                heart = 40,
                chat = 6
            )
        )
        val adapter = MyAdapter(itemList)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedItem = itemList[position]

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                val bundle = Bundle().apply {
                    putInt("img", selectedItem.img)
                    putString("name", selectedItem.name)
                    putString("info", selectedItem.info)
                    putString("seller", selectedItem.seller)
                    putInt("price", selectedItem.price)
                    putString("locate", selectedItem.locate)
                    putInt("heart", selectedItem.heart)
                    putInt("chat", selectedItem.chat)
                }
                intent.putExtra("bundle", bundle)
                startActivity(intent)
            }
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 26 버전 이상일 경우
            val channelId = "one-channel"
            val channelName = "My Channel One"

            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT

            ).apply {
                // 채널에 다양한 정보 설정
                description = "My Channel One Description"
                setShowBadge(true) // 뱃지 설정

                // 알림이 울릴 때 소리 설정
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true) // 진동 넣을지 말지
            }
            // 채널을 NotificationManager 에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId)

        } else {
            // 26 버전 이하
            builder = NotificationCompat.Builder(this)
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_foreground)
        val intent = Intent(this, DetailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        // 알림 권한 확인
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                // 알림 권한이 없다면, 사용자에게 권한 요청
                val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                    putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                }
                startActivity(intent)
            }
        }

        // 알림의 기본 경로
        builder.run {
            setSmallIcon(R.drawable.bell)
            setWhen(System.currentTimeMillis()) // 알림 발생 시간 = 현재 시간
            setContentTitle("키워드 알림")
            setContentText("설정한 키워드에 대한 알림이 도착했습니다!!")
            setLargeIcon(bitmap)
            addAction(R.mipmap.ic_launcher, "Action", pendingIntent)// 알림을 클릭했을 때 pendingIntent 를 호출하여 SecondActivity가 실행됨
        }

        manager.notify(11, builder.build())
    }
}