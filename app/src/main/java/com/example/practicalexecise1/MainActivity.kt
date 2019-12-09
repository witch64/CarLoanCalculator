package com.example.practicalexecise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        //Getting input data from the user
        val carPrice=editTextCarPrice.text.toString().toInt()
        val downPayment=editTextDownPayment.text.toString().toInt()
        val loanPeriod=editTextLoanPeriod.text.toString().toInt()
        val interestRate=editTextInterestRate.text.toString().toFloat()

        //calculate the loan
        val loan=carPrice-downPayment
        val interest=loan*interestRate*loanPeriod
        val monthPay=(loan+interest)/loanPeriod/12

        //Create an Explicit Intent
        val intent = Intent(this, ResultActivity::class.java)

        intent.putExtra(LOAN, loan)
        intent.putExtra(INTEREST, interest)
        intent.putExtra(MONTHLY_PAYMENT, monthPay)

        startActivity(intent)
    }

    fun resetInput(view : View){
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextInterestRate.setText("")
    }

    companion object {
        const val LOAN = "loan"
        const val INTEREST = "interest"
        const val MONTHLY_PAYMENT = "payment"
    }
}
