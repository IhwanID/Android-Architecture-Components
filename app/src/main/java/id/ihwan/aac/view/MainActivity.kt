package id.ihwan.aac.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import id.ihwan.aac.R
import id.ihwan.aac.adapter.MainAdapter
import id.ihwan.aac.databinding.ActivityMainBinding
import id.ihwan.aac.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecyclerView()
        observeLiveData()
        viewModel.getMovie()
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.layoutManager = layoutManager
        adapter = MainAdapter(this)
        binding.mainRecyclerView.adapter = adapter

    }

    private fun observeLiveData(){
        viewModel.movies.observe(this, Observer {
            adapter.setData(it?.results!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {
            //handle error
        })
    }
}
