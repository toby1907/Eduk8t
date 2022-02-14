package com.example.eduk8t.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.eduk8t.tablayout.AllFragment
import com.example.eduk8t.CoursesFragment
import com.example.eduk8t.NewFragment
import com.example.eduk8t.PopularFragment
import com.example.eduk8t.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.view.*

private const val TAG = "MainActivity"
class HomeFragment : Fragment() {

    //when requested, this adapter retrurns a
    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var viewPager: ViewPager2
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//adapter here

    }

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onDestroy() {
        super.onDestroy()
    }
    class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            // Return a NEW fragment instance in createFragment(int)
            return when (position) {
                0 -> AllFragment()
                1 -> PopularFragment()
                2 -> NewFragment()
                else -> {
                    CoursesFragment()
                }
            }


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //adding viewpager implementation
        val tabLayout = root.tabLayout
        demoCollectionAdapter = DemoCollectionAdapter(this)
        viewPager = root.pager
        viewPager.adapter = demoCollectionAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            //tab.text = "OBJECT ${(position + 1)}"
when(position){
    0 -> tab.text = "All"
    1 -> tab.text = "Popular"
    2-> tab.text = "New"
}
        }.attach()



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}