package community.capacitor.android.security.provider

import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "CapacitorSecurityProvider")
public class CapacitorSecurityProviderPlugin : Plugin() {
    private lateinit var implementation: CapacitorSecurityProvider

    override fun load() {
        implementation = CapacitorSecurityProvider(context)
    }

    @PluginMethod
    public fun installIfNeeded(call: PluginCall) {
        val ret = JSObject()
        ret.put("status", implementation.installIfNeeded())
        call.resolve(ret)
    }
}
