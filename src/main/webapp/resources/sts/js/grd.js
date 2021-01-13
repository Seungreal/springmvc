var grd = grd || {}

grd.register = x=>{
	$(`#mgr-data-mgt-stu`).empty()
	$(`#result-form`).text(`성적 등록화면`)
	$(`<div class="main-block">
      <div class="left-part">
        <i class="fas fa-envelope"></i>
        <i class="fas fa-at"></i>
        <i class="fas fa-mail-bulk"></i>
      </div>
      <form id="grd-register-form">
        <h1>성적 등록 폼</h1>
        <div class="info">
          <input class="fname" type="text" name="name" placeholder="Full name">
          <input type="text" name="name" placeholder="Email">
          <input type="text" name="name" placeholder="Phone number">
          <input type="text" name="name" placeholder="Website">
        </div>
        <p>Message</p>
        <div>
          <textarea rows="4"></textarea>
        </div>
      </form>
    </div>`).appendTo(`#mgr-data-mgt-stu`)

	$(`<button/>`)
	.text(`성적등록`)
	.appendTo(`#grd-register-form`)
	.click(e=>{
		$.getJSON(`${x}/grades/register`,d=>{
			location.href = `${x}/grades/index`
		})
	})
}