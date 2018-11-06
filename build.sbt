sbtPlugin := true
organization := "name.de-vries"
name := "sbt-typescript"
version := "3.1.6-mk"

homepage := Some(url("https://github.com/joost-de-vries/sbt-typescript"))
licenses +=("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.10.6"

sbtVersion := "0.13.16"

updateOptions := updateOptions.value.withCachedResolution(cachedResoluton = true)

scalacOptions ++= Seq(
  "-feature",
  "-encoding", "UTF8",
  "-deprecation",
  "-unchecked",
  "-target:jvm-1.7",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-adapted-args"
)

libraryDependencies ++= Seq(

  // js dependencies
  "org.webjars.npm" % "typescript" % "3.1.6",
  "org.webjars.npm" % "minimatch" % "3.0.0",
  "org.webjars.npm" % "fs-extra" % "0.26.6",
  "org.webjars.npm" % "es6-shim" % "0.35.1"
)

dependencyOverrides ++= Seq(
  "org.webjars" % "webjars-locator" % "0.35",
  "org.webjars" % "webjars-locator-core" % "0.35",

  "org.webjars" % "npm" % "3.9.3"
)

resolvers += "minutekey" at "http://nexus.minutekey.com:8081/repository/public/"

resolvers ++= Seq(
  /* Resolver.bintrayRepo("webjars","maven"), */
  Resolver.typesafeRepo("releases"),
  Resolver.sbtPluginRepo("releases"),
  Resolver.sonatypeRepo("releases"),
  Resolver.mavenLocal
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.2.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.3")

/* publishMavenStyle := false */
//bintrayRepository in bintray := "sbt-plugins"
//bintrayOrganization in bintray := None
//bintrayVcsUrl := Some("git@github.com:joost-de-vries/sbt-typescript.git")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishTo := Some("releases" at "http://nexus.minutekey.com:8081/repository/releases/")
scriptedLaunchOpts += s"-Dproject.version=${version.value}"
scriptedBufferLog := false
