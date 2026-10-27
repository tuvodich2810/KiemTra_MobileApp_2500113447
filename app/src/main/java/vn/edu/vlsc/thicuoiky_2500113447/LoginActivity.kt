package vn.edu.vlsc.thicuoiky_2500113447

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ các thành phần giao diện bằng hàm findViewById truyền thống
        tvTitle = findViewById(R.id.tvTitle)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        // Xử lý sự kiện bấm nút Đăng nhập
        btnLogin.setOnClickListener {
            handleLogin()
        }
    }

    private fun handleLogin() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString().trim()

        // Kiểm tra bỏ trống Email hoặc Mật khẩu
        if (email.isEmpty() || password.isEmpty()) {
            tvStatus.setTextColor(Color.RED)
            tvStatus.text = getString(R.string.error_empty)
            return
        }

        // Kiểm tra định dạng Email
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tvStatus.setTextColor(Color.RED)
            tvStatus.text = getString(R.string.error_invalid_email)
            return
        }

        // Kiểm tra độ dài Mật khẩu (>= 6 ký tự)
        if (password.length < 6) {
            tvStatus.setTextColor(Color.RED)
            tvStatus.text = getString(R.string.error_password_length)
            return
        }

        // Dữ liệu hợp lệ
        tvStatus.setTextColor(Color.parseColor("#2E7D32"))
        tvStatus.text = getString(R.string.login_success)
    }
}
