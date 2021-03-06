require recipes-core/images/core-image-minimal.bb

PACKAGE_ARCH = "${MACHINE_ARCH}"

CORE_IMAGE_EXTRA_INSTALL += "udev-extraconf lsb"
CORE_IMAGE_EXTRA_INSTALL_append_qoriq = " udev-rules-qoriq"

IMAGE_FSTYPES = "tar.gz ext2.gz ext2.gz.u-boot jffs2 ubi"

EXTRA_IMAGEDEPENDS_remove_ls1088a = " rcw dpl-examples"
EXTRA_IMAGEDEPENDS_append_ls1088a = " rcw-bin mc-utils"

EXTRA_IMAGEDEPENDS_remove_ls2088a = " rcw dpl-examples"
EXTRA_IMAGEDEPENDS_append_ls2088a = " rcw-bin mc-utils"

EXTRA_IMAGEDEPENDS_remove_ls1012ardb = " rcw"
EXTRA_IMAGEDEPENDS_append_ls1012ardb = " rcw-bin ppa-optee"

EXTRA_IMAGEDEPENDS_remove_ls1012ardb-32b = " rcw"
EXTRA_IMAGEDEPENDS_append_ls1012ardb-32b = " rcw-bin"

EXTRA_IMAGEDEPENDS_remove_ls1012afrdm = " rcw"
EXTRA_IMAGEDEPENDS_append_ls1012afrdm = " rcw-bin"

EXTRA_IMAGEDEPENDS_remove_ls1012afrdm-32b = " rcw"
EXTRA_IMAGEDEPENDS_append_ls1012afrdm-32b = " rcw-bin"

EXTRA_IMAGEDEPENDS_append_ls1043ardb = " ppa-optee"
EXTRA_IMAGEDEPENDS_append_ls1046ardb = " ppa-optee"

EXTRA_IMAGEDEPENDS_append_p2020rdb = " vsc7385-firmware"

SUMMARY = "Small image to be used for evaluating the Freescale socs"
DESCRIPTION = "Small image which includes some helpful tools and \
Freescale-specific packages. It is much more embedded-oriented \
than fsl-image-networking-full to evaluate the Freescale socs."

LICENSE = "MIT"

IMAGE_INSTALL_append = " \
    packagegroup-core-ssh-openssh \
    packagegroup-fsl-mfgtools \
    packagegroup-fsl-tools-core \
    packagegroup-fsl-benchmark-core \
    packagegroup-fsl-networking-core \
"
IMAGE_INSTALL_append_ls1012a = " packagegroup-fsl-tools-audio"

inherit disable-services
ROOTFS_POSTPROCESS_COMMAND_append_ls1012a = "rootfs_disable_unnecessary_services;"

