class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/"(controller: 'home', action: 'index')

        // This "/r" is a legacy mapping, so we won't lose everything @google
        name poiView: "/r/$id"(controller: 'poi', action: 'index')
        name poiVote: "/r/$id/vote"(controller: 'poi', action: 'vote')

        "500"(view:'/error')
	}
}
