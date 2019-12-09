package com.example.practicalexecise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //To receive data from another Activity
        val loan = intent.getIntExtra(MainActivity.LOAN, 0)
        val interest = intent.getFloatExtra(MainActivity.INTEREST, 0F)
        val monthPay = intent.getFloatExtra(MainActivity.MONTHLY_PAYMENT, 0F)

        //TODO: Display the outputs
        textViewCarLoan.text = getString(R.string.loan)+" ${loan}"
        textViewInterest.text = getString(R.string.interest)+" ${interest}"
        textViewMonthlyPayment.text = getString(R.string.monthly_repayment)+" ${monthPay}"
    }

    fun closeActivity(view : View){
        //reset the text
        textViewCarLoan.setText("")
        textViewInterest.setText("")
        textViewMonthlyPayment.setText("")

        //Terminate the current activity
        finish()
    }
}