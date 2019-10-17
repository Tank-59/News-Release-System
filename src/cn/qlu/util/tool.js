export function getParameters (name) {
  var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i')
  var r = window.location.search.substr(1).match(reg)
  if (r != null) {
    //   return unescape(r[2]);
    return decodeURIComponent(r[2])
  }
  return ''
}

export function getAge (birthday, days) {
  if (!birthday) return
  var r = birthday.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/)
  if (r == null) {
    return false
  }
  ;
  var birth = new Date(r[1], r[3] - 1, r[4])
  if (birth.getFullYear() == r[1] && (birth.getMonth() + 1) == r[3] && birth.getDate() == r[4]) {
    var today = new Date()
    var age = today.getFullYear() - r[1]
    if (today.getMonth() > birth.getMonth()) {
      return age
    }
    if (today.getMonth() == birth.getMonth()) {
      if (today.getDate() >= birth.getDate()) {
        return age
      } else {
        return age - 1
      }

    }
    if (today.getMonth() < birth.getMonth()) {
      return age - 1
    }
  }
  return age
}
