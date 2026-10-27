package vn.edu.vlsc.thicuoiky_2500113447

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvProfileTitle: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ các thành phần giao diện bằng hàm findViewById truyền thống
        tvProfileTitle = findViewById(R.id.tvProfileTitle)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // Nhận dữ liệu chuỗi Email được truyền từ LoginActivity qua Intent/Bundle
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: "Không có dữ liệu"
        tvUserEmail.text = email

        // Xử lý nút Đăng xuất để đóng Activity hiện tại bằng hàm finish() và quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
