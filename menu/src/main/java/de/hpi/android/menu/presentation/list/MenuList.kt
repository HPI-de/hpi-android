package de.hpi.android.menu.presentation.list

import de.hpi.android.menu.domain.Menu

// A future programmer may wonder why this class exists. Well, at the time of writing, data binding support is very
// limited. In particular, there compiler errors are meaningless. I couldn't get generics in data binding variables to
// work, I tried using `kotlin.collections.List&lt;de.hpi.android.menu.domain.Menu>` as the type. Hopefully, this will
// be properly supported in future versions.
data class MenuList(val menus : List<Menu>)
