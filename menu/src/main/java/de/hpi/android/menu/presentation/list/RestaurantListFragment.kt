package de.hpi.android.menu.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.menu.R
import de.hpi.android.menu.databinding.MenuFragmentRestaurantsListBinding
import de.hpi.android.menu.databinding.MenuItemRestaurantCardBinding
import kotlinx.android.synthetic.main.menu_fragment_restaurants_list.*

class RestaurantListFragment : BaseFragment<MenuFragmentRestaurantsListBinding, MenuListViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MenuListViewModel::class.java)
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): MenuFragmentRestaurantsListBinding {
        return MenuFragmentRestaurantsListBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseActivity.setSupportActionBar(view.findViewById(R.id.toolbar))

        viewModel.menus.observe(this, Observer { menus ->
            restaurantsList.removeAllViews()
            menus ?: return@Observer

            for ((restaurant, menusOfRestaurant) in menus.groupBy { menu -> menu.restaurant })
                MenuItemRestaurantCardBinding.inflate(
                    LayoutInflater.from(context),
                    restaurantsList,
                    true
                ).also { binding ->
                    binding.restaurant = restaurant
                    for (menu in menusOfRestaurant)
                        binding.content.addView(MenuView(context!!).also {
                            it.menu = menu
                        })
                }
        })
    }
}
