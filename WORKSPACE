workspace(name = "de_bsw_BSWj2cl")

# Load j2cl repository
# If you are not developing with J2CL, you may want to use a remote repository
# instead. See WORKSPACE.remote for the alternative.
local_repository(
    name = "com_google_j2cl",
    path = "../..",
)

load("@com_google_j2cl//build_defs:repository.bzl", "load_j2cl_repo_deps")
load_j2cl_repo_deps()

load("@com_google_j2cl//build_defs:rules.bzl", "setup_j2cl_workspace")
setup_j2cl_workspace()