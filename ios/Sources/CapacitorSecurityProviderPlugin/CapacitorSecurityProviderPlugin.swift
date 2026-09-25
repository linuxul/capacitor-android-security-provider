import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CapacitorSecurityProviderPlugin)
public class CapacitorSecurityProviderPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "CapacitorSecurityProviderPlugin"
    public let jsName = "CapacitorSecurityProvider"
    public let pluginMethods: [CAPPluginMethod] = [
        .promise("installIfNeeded", CapacitorSecurityProviderPlugin.installIfNeeded)
    ]
    private let implementation = CapacitorSecurityProvider()

    func installIfNeeded(_ call: CAPPluginCall) {
        call.resolve([
            "status": "NotImplemented"
        ])
    }
}
