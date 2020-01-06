package com.example.mywallet

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        buttonSave.setOnClickListener {
            saveRecord()
        }


    }


    private fun saveRecord() {
        if (TextUtils.isEmpty(editTextAmount.text)) {
            editTextAmount.setError("Value is required")
            return
        }

        val amount = editTextAmount.text.toString();

        intent.putExtra(AMOUNT, amount)

        val radioType = radioGroupType.checkedRadioButtonId
        if (radioType == R.id.radioButtonIncome) {
            intent.putExtra(TYPE, 1)
        } else {
            intent.putExtra(TYPE, 0)
        }
        setResult(Activity.RESULT_OK, intent)

        finish()
    }


companion object {
    const val TYPE = "com.example.mywallet.type"
    const val AMOUNT = "com.example.mywallet.amount"
}

}
