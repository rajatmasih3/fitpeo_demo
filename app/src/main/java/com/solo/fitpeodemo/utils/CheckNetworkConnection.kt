import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class CheckNetworkConnection {

    companion object {
        fun isNetworkAvailable(context: Context?): Boolean {
            var networkFlag = false
            if (context == null) return networkFlag
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                            networkFlag = true
                            return networkFlag
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                            networkFlag = true
                            return networkFlag
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                            networkFlag = true
                            return networkFlag
                        }
                    }
                }
            } else {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                    networkFlag = true
                    return networkFlag
                }
            }
            if(!networkFlag){
                try {

                }catch (e:Exception){

                }
            }
            return false
        }
    }
}