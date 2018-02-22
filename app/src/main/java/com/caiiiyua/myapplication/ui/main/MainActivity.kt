package com.caiiiyua.myapplication.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.caiiiyua.myapplication.R
import com.caiiiyua.myapplication.base.ui.BaseActivity
import com.caiiiyua.myapplication.data.remote.model.Ribot
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

  @Inject lateinit var presenter: MainPresenter
  @Inject lateinit var ribotsAdapter: RibotsAdapter

  @BindView(R.id.recycler_view) lateinit var recyclerView: RecyclerView

  private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_home -> {
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_dashboard -> {
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_notifications -> {
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    activityComponent.inject(this)

    setContentView(R.layout.activity_main)
    ButterKnife.bind(this)

    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    recyclerView.adapter = ribotsAdapter
    recyclerView.layoutManager = LinearLayoutManager(this)
    presenter.attachView(this)
    presenter.loadRibots()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }

  override fun showRibots(ribots: List<Ribot>) {
    ribotsAdapter.ribots = ribots
    ribotsAdapter.notifyDataSetChanged()
  }

  override fun showRibotsEmpty() {
    ribotsAdapter.ribots = emptyList()
    ribotsAdapter.notifyDataSetChanged()
    Toast.makeText(this, R.string.empty_ribots, Toast.LENGTH_LONG).show()
  }

  override fun showError() {
    Toast.makeText(this, R.string.error_loading_ribots, Toast.LENGTH_LONG).show()
  }
}
