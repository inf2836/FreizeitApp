package de.tinacode.freizeitapp.menu.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import de.tinacode.freizeitapp.R

class SettingFragment  : PreferenceFragmentCompat() {

    private var prefUserName: EditTextPreference? = null
    private var prefEmail: EditTextPreference? = null
    private var prefbday: Preference? = null
    private var prefPassword: EditTextPreference? = null

    private lateinit var sharedPreferences: SharedPreferences

    private var username = ""
    private var email = ""
    private var bday = ""
    private var password = ""


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings,rootKey)

        prefUserName = findPreference("et_pref_username")
        prefEmail= findPreference("et_pref_email")
        prefbday = findPreference("pref_bday")
        prefPassword = findPreference("et_pref_password")

        loadDataFromPreferences()

        prefbday?.setOnPreferenceClickListener {
            setNewBirthday()
            true
        }

        // set input type
        prefUserName?.setOnBindEditTextListener { editText ->
            editText.inputType = InputType.TYPE_CLASS_TEXT
        }

        prefEmail?.setOnBindEditTextListener { editText ->
            editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }

        prefPassword?.setOnBindEditTextListener { editText ->
            editText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
        }




        prefUserName?.summaryProvider = EditTextPreference.SimpleSummaryProvider.getInstance()
        prefEmail?.summaryProvider = EditTextPreference.SimpleSummaryProvider.getInstance()
        prefPassword?.summaryProvider = Preference.SummaryProvider<EditTextPreference> { preference ->
            val text = preference.text
            if(TextUtils.isEmpty(text)){
                "No password was set"
            }
            else{
                var length = text?.length
                var value = "*".repeat(length!!)
                value
            }

        }

    }



    private fun loadDataFromPreferences(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        username = sharedPreferences.getString("et_pref_username", "")!!
        email = sharedPreferences.getString("et_pref_email", "")!!
        bday = sharedPreferences.getString("pref_bday", "")!!
        password = sharedPreferences.getString("et_pref_password", "")!!

    }

    private fun setNewBirthday(){
        val bday = "01.01.1990"
        sharedPreferences.edit()
            .putString("pref_bday", bday)
            .commit()
    }

}