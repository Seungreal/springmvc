var cmm = cmm || {}

cmm.generateDB = x => {
	$.getJSON(`${x}/common/generate/db`,d => {
		 location.reload()
	})
}