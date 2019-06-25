package de.hpi.android.menu.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.menu.R
import de.hpi.android.menu.databinding.FragmentRestaurantCardBinding
import de.hpi.android.menu.databinding.FragmentRestaurantsListBinding
import kotlinx.android.synthetic.main.fragment_restaurants_list.*
import kotlinx.android.synthetic.main.item_restaurant_card.*

class RestaurantsListFragment : BaseFragment<FragmentRestaurantsListBinding, MenuListViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MenuListViewModel::class.java)
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentRestaurantsListBinding {
        return FragmentRestaurantsListBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseActivity.setSupportActionBar(view.findViewById(R.id.toolbar))

        viewModel.menus.observe(this, Observer { menus ->
            restaurantsList.removeAllViews()
            for ((restaurant, menusOfRestaurant) in menus?.groupBy { menu -> menu.restaurant }.orEmpty()) {
                FragmentRestaurantCardBinding.inflate(LayoutInflater.from(context), restaurantsList, true).also {
                    it.restaurant = restaurant
                    for (menu in menusOfRestaurant) {
                        restaurantCardContent.addView(MenuView())
                    }
                }
            }
        })
    }
}
