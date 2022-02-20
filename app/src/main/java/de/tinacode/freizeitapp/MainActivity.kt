package de.tinacode.freizeitapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import de.tinacode.freizeitapp.day.fragment.BallonFragment
import de.tinacode.freizeitapp.day.fragment.PicknickFragment
import de.tinacode.freizeitapp.day.fragment.SwimmingFragment
import de.tinacode.freizeitapp.day.fragment.WalkingFragment
import de.tinacode.freizeitapp.menu.fragment.DayFragment
import de.tinacode.freizeitapp.menu.fragment.HomeFragment
import de.tinacode.freizeitapp.menu.fragment.NightFragment
import de.tinacode.freizeitapp.menu.fragment.SettingFragment
import de.tinacode.freizeitapp.model.DataModel
import de.tinacode.freizeitapp.night.fragment.BowlingFragment
import de.tinacode.freizeitapp.night.fragment.IceRunwayFragment
import de.tinacode.freizeitapp.night.fragment.KaraokeFragment
import de.tinacode.freizeitapp.night.fragment.RestaurantFragment


private const val WALKING_TAG = "Walking"
private const val PICKNICK_TAG = "Picknick"
private const val BALLON_TAG = "Air Ballon"
private const val SWIM_TAG = "Swimming"
private const val RESTAURANT_TAG = "Restaurant"
private const val BOWLING_TAG = "Bowling"
private const val ICE_TAG = "Ice Runway"
private const val KARAOKE_TAG = "Karaoke"

class MainActivity : AppCompatActivity(), DayFragment.ActivityCallbacks,
    NightFragment.ActivityCallbacks, SwimmingFragment.ActivityCallbacks,
    WalkingFragment.ActivityCallbacks, BallonFragment.ActivityCallbacks,
    PicknickFragment.ActivityCallbacks, BowlingFragment.ActivityCallbacks,
    IceRunwayFragment.ActivityCallbacks, KaraokeFragment.ActivityCallbacks,
    RestaurantFragment.ActivityCallbacks, HomeFragment.ActivityCallbacks {


    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, HomeFragment())
            .commit()

        val userId = intent.getStringExtra("user")
        val email = intent.getStringExtra("email")
        val view: View = LayoutInflater.from(this).inflate(R.layout.header, null)
        val user = view.findViewById<TextView>(R.id.user)
        user.text = email

        drawerLayout = findViewById(R.id.drawerLayout)

        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment(), it.toString())
                //R.id.favorite-> replaceFragment(FavoriteFragment(), it.toString())
                R.id.day-> replaceFragment(DayFragment(), it.toString())
                R.id.night-> replaceFragment(NightFragment(), it.toString())
                R.id.setting -> replaceFragment(SettingFragment(), it.toString())
                R.id.logout -> {
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this, LoginActivity ::class.java))
                    finish()
                }
            }
            true
        }






    }

    private fun replaceFragment(fragment: Fragment,title: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout,fragment,title)
            .addToBackStack(null)
            .commit()

        drawerLayout.closeDrawers()
        setTitle(title)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return  true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun openSwimmingFragment() {
        replaceFragment(SwimmingFragment(),SWIM_TAG)
    }

    override fun openPicknickFragment() {
        replaceFragment(PicknickFragment(), PICKNICK_TAG)
    }
    override fun openWalkingFragment(){
        replaceFragment(WalkingFragment(), WALKING_TAG)
    }
    override fun openBallonFragment(){
        replaceFragment(BallonFragment(), BALLON_TAG)
    }

    override fun openRestaurantFragment() {
        replaceFragment(RestaurantFragment(), RESTAURANT_TAG)
    }

    override fun openBowlingFragment() {
        replaceFragment(BowlingFragment(), BOWLING_TAG)
    }

    override fun openIceRunwayFragment() {
        replaceFragment(IceRunwayFragment(), ICE_TAG)
    }

    override fun openKaraokeFragment() {
        replaceFragment(KaraokeFragment(), KARAOKE_TAG)
    }

    override fun openBallonDetails(data: DataModel) {
        replaceFragment(DetailsFragment.newInstance(data,"ballon"), "Ballon Details")
    }

    override fun openPicknickDetails(data: DataModel) {
        replaceFragment(DetailsFragment.newInstance(data,"picknick"), "Picknick Details")
    }

    override fun openSwimmingDetails(data: DataModel) {
        replaceFragment(DetailsFragment.newInstance(data,"swimmer"), "Swimming Details")
    }

    override fun openWalkingDetails(data: DataModel) {
        replaceFragment(DetailsFragment.newInstance(data,"walking"), "Walking Details")
    }

    override fun openBowlingDetails(data: DataModel) {
        replaceFragment(DetailsFragment.newInstance(data,"bowling"), "Bowling Details")
    }

    override fun openIceRunwayDetails(data: DataModel) {
        replaceFragment(DetailsFragment.newInstance(data,"ice"), "Ice Runway Details")
    }

    override fun openKaraokeDetails(data: DataModel) {
        replaceFragment(DetailsFragment.newInstance(data,"karaoke"), "Karaoke Details")
    }

    override fun openRestaurantDetails(data: DataModel) {
        replaceFragment(DetailsFragment.newInstance(data,"restaurant"), "Restaurant Details")
    }

    override fun openSwimming() {
        openSwimmingFragment()
    }

    override fun openBowling(){
        openBowlingFragment()
    }

    override fun openWalking() {
        openWalkingFragment()
    }

    override fun openBallon() {
        openBallonFragment()
    }

    override fun openKaraoke() {
        openKaraokeFragment()
    }

    override fun openRestaurant() {
        openRestaurantFragment()
    }
}


