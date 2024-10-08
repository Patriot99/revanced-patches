package app.revanced.patches.youtube.shorts.components.fingerprints

import app.revanced.patcher.fingerprint.MethodFingerprint
import com.android.tools.smali.dexlib2.Opcode

internal object ShortsPausedHeaderFingerprint : MethodFingerprint(
    returnType = "Landroid/view/View;",
    opcodes = listOf(
        Opcode.IF_NEZ,
        Opcode.IGET_OBJECT,
        Opcode.CONST,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT_OBJECT
    ),
    strings = listOf("r_pfcv")
)