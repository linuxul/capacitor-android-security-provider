import XCTest
@testable import CapacitorSecurityProviderPlugin

class CapacitorSecurityProviderTests: XCTestCase {
    func testInstallIsNotImplementedOnIOS() {
        XCTAssertEqual(CapacitorSecurityProvider().installIfNeeded(), "NotImplemented")
    }

    func testPluginRegistration() {
        let plugin = CapacitorSecurityProviderPlugin()

        XCTAssertEqual(plugin.identifier, "CapacitorSecurityProviderPlugin")
        XCTAssertEqual(plugin.jsName, "CapacitorSecurityProvider")
        XCTAssertEqual(plugin.pluginMethods.map(\.name), ["installIfNeeded"])
        XCTAssertTrue(plugin.pluginMethods.allSatisfy { $0.returnType == .promise })
    }
}
