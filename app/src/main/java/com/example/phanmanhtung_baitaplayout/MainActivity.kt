package com.example.phanmanhtung_baitaplayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgAvatar = findViewById<ImageView>(R.id.imgAvatar)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvSchool = findViewById<TextView>(R.id.tvSchool)
        val edtNote = findViewById<EditText>(R.id.edtNote)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val switchNotify = findViewById<SwitchMaterial>(R.id.switchNotify)
        val btnSave = findViewById<Button>(R.id.btnSave)

        imgAvatar.setOnClickListener {
            Toast.makeText(this, "Ảnh thẻ sinh viên: Phan Mạnh Tùng", Toast.LENGTH_SHORT).show()
        }

        switchNotify.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "Đã BẬT" else "Đã TẮT"
            Toast.makeText(this, "$status thông báo học vụ", Toast.LENGTH_SHORT).show()
        }

        btnSave.setOnClickListener {
            val note = edtNote.text.toString().trim()

            if (note.isBlank()) {
                edtNote.error = "Vui lòng nhập lớp sinh hoạt hoặc ghi chú!"
                edtNote.requestFocus()
                return@setOnClickListener
            }

            val gender = when (rgGender.checkedRadioButtonId) {
                R.id.rbMale -> "Nam"
                R.id.rbFemale -> "Nữ"
                else -> "Chưa xác định"
            }

            tvName.text = "Phan Mạnh Tùng ($gender)"
            tvSchool.text = "Lớp/Ghi chú: $note - ĐH SPKT"

            edtNote.text?.clear()
            Toast.makeText(this, "Đã lưu thông tin lên thẻ sinh viên!", Toast.LENGTH_SHORT).show()
        }
    }
}