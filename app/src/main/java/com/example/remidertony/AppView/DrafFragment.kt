package com.example.remidertony.AppView

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import com.example.remidertony.MainActivity
import com.example.remidertony.R
import kotlinx.android.synthetic.main.draf_fragment.view.*
import java.util.*

class DrafFragment : Fragment(),DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var saveDay = 0
    var saveMonth = 0
    var saveYear = 0
    var saveHour = 0
    var saveMinute = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.draf_fragment,container,false)
        pickDate(view)
        return view
    }
    private fun getDateTimeCalendar(){
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }
    private fun pickDate(view : View){
        view.bt_showTime.setOnClickListener {
            getDateTimeCalendar()
            DatePickerDialog(activity as MainActivity,this,year,month,day).show()
        }
        
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        saveDay = dayOfMonth
        saveMonth = month
        saveYear = year
        getDateTimeCalendar()
        TimePickerDialog(activity as MainActivity,this,hour,minute,true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        saveHour = hourOfDay
        saveMinute = minute
    }
}