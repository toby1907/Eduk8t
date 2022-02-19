package com.example.eduk8t.tablayout

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eduk8t.R
import com.example.eduk8t.adapter.CoursesAdapter
import com.example.eduk8t.databinding.AllFragmentBinding
import com.example.eduk8t.databinding.CourseListItemBinding
import com.example.eduk8t.databinding.FragmentHomeBinding
import com.example.eduk8t.ui.home.HomeViewModel

class AllFragment : Fragment() {

    companion object {
        fun newInstance() = AllFragment()
    }

    private  val viewModel: AllViewModel by viewModels()
private lateinit var binding: AllFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AllFragmentBinding.inflate(layoutInflater)
        binding = AllFragmentBinding.inflate(inflater, container, false)

        return binding.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNewCourses()
    }

    private fun setupNewCourses() {
        val newCoursesAdapter = CoursesAdapter()
        binding.recyclerView2.adapter = newCoursesAdapter
        binding.recyclerView2.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        viewModel.topCourses.observe(viewLifecycleOwner,{
            newCoursesAdapter.submitList(it)
        })
    }



}