class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/"(controller: 'home', action: 'index')

        // This "/r" is a legacy mapping, so we won't lose everything @google
        "/r/$id"(controller: 'poi', action: 'index')

        "500"(view:'/error')
	}
}
