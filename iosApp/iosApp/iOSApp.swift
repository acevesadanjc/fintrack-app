import SwiftUI

@main
struct iOSApp: App {

    init() {
        LoggerInitializerKt.initializeLogger()
        KoinIOSKt.doInitKoinIOS()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}