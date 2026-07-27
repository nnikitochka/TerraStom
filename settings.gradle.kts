rootProject.name = "terrastom"

includeBuild("build-src")

include("code-generators")
include("testing")

include("jmh-benchmarks")
include("jcstress-tests")

include("demo")
